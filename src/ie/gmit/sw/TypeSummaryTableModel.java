package ie.gmit.sw;

/** 
* @author Paul Dolan - G00297086
* Model for table component in AppSummary window
*/

import javax.swing.table.*;
public class TypeSummaryTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 777L;
	private String[] cols = {"Class", "In Degree", "Out Degree", "Stability"};
	private Object[][] data = {
		{"Stuff 1", "Other Stuff 1", "Even More Stuff 1", " "},
	};
	
	//Sets table data
	public void setTableData(Object[][] data){
		this.data = data;
	}
	
    /**
     * Gets number of columns in the table
     *
     * @return
     * Returns the number
     */
	
	public int getColumnCount() {
        return cols.length;
    }
	
    /**
     * Gets number of rows in the table.
     *
     * @return
     * Returns the number
     */
	
    public int getRowCount() {
        return data.length;
	}
    
    
    /**
     * Gets name of a column
     * @param col
     * Location of column
     *
     * @return
     * The name of the column
     */

    public String getColumnName(int col) {
    	return cols[col];
    }
    
    /**
     * Gets value of a row and column in the table
     *
     * @param row
     * Location of the row in the table
     *
     * @param col
     * Location of the column in the table
     *
     * @return
     * Returns an object value
     */

    public Object getValueAt(int row, int col) {
        return data[row][col];
	}
    

    /**
     * Gets class that is in the first row of the column
     *
     * @param c
     * Location of the column in the table
     *
     * @return
     * Returns the class of the column selected
     */
   
    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
	}
}