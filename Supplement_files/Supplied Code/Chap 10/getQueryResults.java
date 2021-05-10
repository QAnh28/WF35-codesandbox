public static Vector<Object> getQueryResults()
                                 throws SQLException
{
   results = statement.executeQuery(getQuery());
   metaData = results.getMetaData();
   numFields = metaData.getColumnCount();

   queryResults = new Vector<Object>();
   fieldNames = new Vector<String>();
   dataTypes = new Vector<String>();

   for (int i=1; i<=numFields; i++)
      fieldNames.add(metaData.getColumnName(i));

   while (results.next())
   {
      for (int i=1; i<=numFields; i++)
      {
	      int colType = metaData.getColumnType(i);

	      switch (colType)
         {
            case Types.INTEGER:
               queryResults.add(results.getInt(i));
               dataTypes.add("integer");
               break;
            case Types.VARCHAR:
               queryResults.add(
                              results.getString(i));
               dataTypes.add("string");
               break;
	         case Types.NUMERIC:
               queryResults.add(
                               results.getFloat(i));
               dataTypes.add("float");
               break;
            default: //Hopefully, will never happen!
               queryResults.add(
                              results.getString(i));
               dataTypes.add("string");
         }
      }
   }
   return queryResults;
}
