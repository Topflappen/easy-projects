package de.aisy.immo.controller.internet.step.impl;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import de.aisy.immo.constants.ImmoscoutPageConstants;
import de.aisy.immo.controller.actions.InternetActions;
import de.aisy.immo.controller.internet.step.BaseStep;
import de.aisy.immo.controller.internet.util.Finder;
import de.aisy.immo.controller.internet.validator.ObjectOverviewValidator;
import de.aisy.immo.model.InsertedObjectInfo;
import de.framework.commons.util.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 19:51
 * To change this template use File | Settings | File Templates.
 */
public class ListObjectsStep extends BaseStep<List<InsertedObjectInfo>> {

    public ListObjectsStep() {
        super(new ObjectOverviewValidator());
    }

    @Override
    protected HtmlPage proceedImpl() throws IOException {

        HtmlPage htmlPage = InternetActions.getInstance().goToObjectsOverview();

        return htmlPage;
    }

    @Override
    protected List<InsertedObjectInfo> produceResult(HtmlPage htmlPage) {

        List<InsertedObjectInfo> result = new ArrayList<InsertedObjectInfo>();

        HtmlElement tableElement = Finder.findIn(htmlPage).byTag("table").filter().byAttributeValue("class", ImmoscoutPageConstants.OBJECTS_TABLE_CLASS_NAME).singleResult();

        if(tableElement == null) {
            return null;
        }

        HtmlElement body = Finder.findIn(tableElement).byTag("tbody").singleResult();

        if(body == null) {
            return null;
        }

        List<HtmlElement> trs = Finder.findIn(body).byTag("tr").filter().byAttributeValueStartsWith("id", "headRow").results();

		//is24-am-details
		List<HtmlElement> detailTrs = Finder.findIn(body).byTag("tr").filter().byAttributeValueStartsWith("id", "details").results();

        for(int i= 0; i<Math.min(trs.size(), detailTrs.size()); i++) {

			String title = "";
			String scoutId = "";
			String objectId = "";

			HtmlElement tr = trs.get(i);
			HtmlElement detailTr = detailTrs.get(i);

            HtmlElement a = Finder
                    .findIn(tr).byTag("td").filter().byAttributeValue("colspan", "5")
                    .findInSingleResult().byTag("h4")
                    .findInSingleResult().byTag("a")
                    .singleResult();

			if(a != null) {
				title = StringUtil.ensureNotNull(a.getTextContent()).trim();
            }

			HtmlElement idList = Finder
					.findIn(detailTr).byTag("td").filter().byAttributeValue("colspan", "5")
					.findInSingleResult().byTag("div").filter().byAttributeValueLike("class", "object-ids")
					.findInSingleResult().byTag("ul").singleResult();

			if(idList != null) {

				List<HtmlElement> listElements = Finder.findIn(idList).byTag("li").results();

				for(HtmlElement listElement: listElements) {

					String content = StringUtil.ensureNotNull(listElement.getTextContent()).trim();

					if(content.startsWith(ImmoscoutPageConstants.OBJECT_SCOUT_ID_IDENTIFIER)) {
						scoutId = content.replace(ImmoscoutPageConstants.OBJECT_SCOUT_ID_IDENTIFIER,"");
					}
					else if(content.startsWith(ImmoscoutPageConstants.OBJECT_OBJECT_ID_IDENTIFIER)) {
						objectId = content.replace(ImmoscoutPageConstants.OBJECT_OBJECT_ID_IDENTIFIER,"");
					}
				}
			}

			if(StringUtil.notEmpty(title) && StringUtil.notEmpty(objectId)) {
				result.add(new InsertedObjectInfo(title, scoutId, objectId));
			}
        }

        return result;
    }

}
