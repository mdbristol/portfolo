try {
      con.setAutoCommit(false);
      updateSales = con.prepareStatement(updateString);
      updateTotal = con.prepareStatement(updateStatement);

      for (Map.Entry<String, Integer> e : salesForWeek.entrySet()) {
        updateSales.setInt(1, e.getValue().intValue());
        updateSales.setString(2, e.getKey());
        updateSales.executeUpdate();

        updateTotal.setInt(1, e.getValue().intValue());
        updateTotal.setString(2, e.getKey());
        updateTotal.executeUpdate();
        con.commit();
      }
    } catch (SQLException e ) {
      JDBCTutorialUtilities.printSQLException(e);
      if (con != null) {
        try {
          System.err.print("Transaction is being rolled back");
          con.rollback();
        } catch(SQLException excep) {
          JDBCTutorialUtilities.printSQLException(excep);
        }
      }
    } finally {
      if (updateSales != null) { updateSales.close(); }
      if (updateTotal != null) { updateTotal.close(); }
      con.setAutoCommit(true);
    }