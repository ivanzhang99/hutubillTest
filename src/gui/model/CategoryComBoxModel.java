package gui.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import org.jdesktop.swingx.JXDatePicker;

import entity.Category;
import service.CategoryService;

public class CategoryComBoxModel implements ComboBoxModel<Category> {

	public List<Category> cs = new CategoryService().list();
	public Category c;
//	public JXDatePicker datepick = new JXDatePicker(new Date());

	public CategoryComBoxModel() {
		if (!cs.isEmpty()) {
			c = cs.get(0);

		}
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return cs.size();
	}

	@Override
	public Category getElementAt(int index) {
		// TODO Auto-generated method stub
		return cs.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		c = (Category) anItem;
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		if (!cs.isEmpty()) {

			return c;
		} else {
			return null;
		}
	}

}
