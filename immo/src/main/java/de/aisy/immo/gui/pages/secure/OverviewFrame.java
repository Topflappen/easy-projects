package de.aisy.immo.gui.pages.secure;

import de.aisy.immo.controller.internet.step.Step;
import de.aisy.immo.controller.internet.step.StepExecutor;
import de.aisy.immo.controller.internet.step.impl.ListObjectsStep;
import de.aisy.immo.gui.base.PagePanel;
import de.aisy.immo.model.InsertedObjectInfo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public class OverviewFrame extends PagePanel implements StepExecutor.ResultHandler<List<InsertedObjectInfo>> {

    private static OverviewFrame instance;

    //private JTextArea textArea;

	private JTable table;

	private JLabel label;

    public static OverviewFrame getInstance() {

        if(instance == null) {
            instance = new OverviewFrame();
        }

        return instance;
    }

    private OverviewFrame() throws HeadlessException {
        init();
    }

    private void init() {

		 setBorder(BorderFactory.createEmptyBorder(50, 5, 5, 5));

        LayoutManager gridLayout = new BoxLayout(this, BoxLayout.Y_AXIS);//new GridLayout(4, 4, 10, 10);
        setLayout(gridLayout);

        this.setSize(800, 600);
        this.label = new JLabel();
        this.label.setText("Objekte werden geladen...");
		this.add(label);
        //textArea.setBackground(getBackground());
        //this.add(label);

		/*
		this.table = new JTable(new String[][] {
				{"asd","asd","asd","asd","asd","asd","asd","asd","asd","asd"},
				{"asda","asfd","asd","asd","asd","asd","asd","aasdsd","asd","asd"},
				{"asda","afsd","asd","asd","asd","asd","asd","aNNNsd","asd","asd"},
				{"asda","afsd","asd","asd","asd","asd","asd","aNNNsd","asd","asd"},
				{"asda","afsd","asd","asd","asd","asd","asd","aNNNsd","asd","asd"},
				{"asda","afsd","asd","asd","asd","asd","asd","aNNNsd","asd","asd"},
		},
				new String[] {
					"t1", "t2", "t3", "23", "asd"
				});

		//this.table.setSize(600, 600);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		//table.setPreferredSize(new Dimension(600, 600));
		table.setPreferredScrollableViewportSize(new Dimension(800, 800));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane);*/

    }


    @Override
    public void onBecomeActive(Object data) {
        StepExecutor.getInstance().executeStep(true, new ListObjectsStep(), this);
    }

    public void onExecuted(Step.Result result, Step<List<InsertedObjectInfo>> step) {

		String[] columnNames = new String[] {
				"Titel", "Scout-ID", "Objekt-ID"
		};

		List<String[]> rowData = new ArrayList<String[]>();

        if(result.equals(Step.Result.SUCCESS)) {

            List<InsertedObjectInfo> objects = step.getResult();

            StringBuilder stringBuilder = new StringBuilder();

			//rowData[0] = new ArrayList<String>();
			//rowData[1] = new ArrayList<String>();
			//rowData[2] = new ArrayList<String>();

            for(InsertedObjectInfo object: objects) {

				rowData.add(new String[] {
					object.getTitle(), object.getScoutId(), object.getObjectId()
				});

            }

			String[][] rowDataArray = rowData.toArray(new String[0][0]);

			this.table = new JTable(rowDataArray, columnNames);

			this.table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

			//table.setPreferredSize(new Dimension(600, 600));
			table.setPreferredScrollableViewportSize(new Dimension(800, 800));
			table.setFillsViewportHeight(true);

			JScrollPane scrollPane = new JScrollPane(table);
			this.add(scrollPane);

			this.label.setText("");
        }

    }
}
