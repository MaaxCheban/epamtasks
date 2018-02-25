package com.cheban.model.TableStructure;

/**
 * Created by MAX on 25.02.2018.
 */
public class ColumnStructure {
    String columnName;
    String columnType;
    boolean isNull;
    boolean isAutoIncremented;
    boolean isPrimaryKey;
    boolean isForeignKey;
    int columnSize;


   public String getColumnName(){
       return columnName;
   }

   public void setColumnName(String _columnName){
       columnName = _columnName;
   }

   public String getColumnType(){
       return columnType;
   }

    public void setColumnType(String _columnType){
        columnType = _columnType;
    }

   public boolean getIsNull(){
       return isNull;
   }

   public void setIsNull(boolean _isNull){
       isNull = _isNull;
   }

   public boolean getisAutoIncremented(){
       return isAutoIncremented;
   }

   public void setIsAutoIncremented(boolean _isAutoIncremented){
       isAutoIncremented = _isAutoIncremented;
   }

    public boolean getIsPrimaryKey(){
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean _isPrimaryKey){
        isPrimaryKey = _isPrimaryKey;
    }

    public boolean getIsForeignKey(){
        return isForeignKey;
    }

    public void setIsForeignKey(boolean _isForeignKey){
        isForeignKey = _isForeignKey;
    }

   public void setColumnSize(int _columnSize){
       columnSize = _columnSize;
   }

   public int getColumnSize(){
       return columnSize;
   }


   @Override
   public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append(columnName);
       sb.append("\t" + columnType);
       sb.append("(" + columnSize + ")");
       sb.append("\t" + (isNull ? "NULL" : "NOT NULL") );
       if(isAutoIncremented){
           sb.append("\t" + "AUTO_INCREMENT");
       }
       if(isPrimaryKey){
           sb.append("\t" + "PRIMARY KEY");
       }
       if(isForeignKey){
           sb.append("\t" + "FOREIGN KEY");
       }

       return sb.toString();
   }

}
