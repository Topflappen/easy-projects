package de.aisy.immo.controller.internet.step.impl;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import de.aisy.immo.constants.ImmoscoutPageConstants;
import de.aisy.immo.controller.actions.InternetActions;
import de.aisy.immo.controller.internet.step.BaseStep;
import de.aisy.immo.controller.internet.util.Finder;
import de.aisy.immo.controller.internet.validator.ObjectOverviewValidator;
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
public class ListObjectsStep extends BaseStep<List<String>> {

    public ListObjectsStep() {
        super(new ObjectOverviewValidator());
    }

    @Override
    protected HtmlPage proceedImpl() throws IOException {

        HtmlPage htmlPage = InternetActions.getInstance().goToObjectsOverview();

        return htmlPage;
    }

    @Override
    protected List<String> produceResult(HtmlPage htmlPage) {

        List<String> result = new ArrayList<String>();

        HtmlElement tableElement = Finder.findIn(htmlPage).byTag("table").filter().byAttributeValue("class", ImmoscoutPageConstants.OBJECTS_TABLE_CLASS_NAME).singleResult();

        if(tableElement == null) {
            return null;
        }

        HtmlElement body = Finder.findIn(tableElement).byTag("tbody").singleResult();

        if(body == null) {
            return null;
        }

        List<HtmlElement> trs = Finder.findIn(body).byTag("tr").filter().byAttributeValueStartsWith("id", "headRow").results();

        for(HtmlElement tr: trs) {

            /*
            HtmlElement td = Finder.find(tr).byTag("td").filter().byAttributeValue("colspan", "5").singleResult();

            if(td == null) {
                continue;
            }

            HtmlElement div = Finder.find(td).byTag("h4").singleResult();

            if(div == null) {
                continue;
            }                                                                                       */

            HtmlElement a = Finder
                    .findIn(tr).byTag("td").filter().byAttributeValue("colspan", "5")
                    .findInSingleResult().byTag("h4")
                    .findInSingleResult().byTag("a")
                    .singleResult();

            if(a != null) {
                result.add(StringUtil.ensureNotNull(a.getTextContent()).trim());
            }
        }

        return result;
    }

}
