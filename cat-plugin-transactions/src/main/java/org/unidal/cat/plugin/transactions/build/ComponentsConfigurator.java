package org.unidal.cat.plugin.transactions.build;

import java.util.ArrayList;
import java.util.List;

import org.unidal.cat.plugin.transactions.TransactionsPipeline;
import org.unidal.cat.plugin.transactions.TransactionsReportAggregator;
import org.unidal.cat.plugin.transactions.TransactionsReportDelegate;
import org.unidal.cat.plugin.transactions.TransactionsReportManager;
import org.unidal.cat.plugin.transactions.filter.TransactionsHelper;
import org.unidal.cat.plugin.transactions.filter.TransactionsNameFilter;
import org.unidal.cat.plugin.transactions.filter.TransactionsTypeFilter;
import org.unidal.lookup.configuration.AbstractResourceConfigurator;
import org.unidal.lookup.configuration.Component;

public class ComponentsConfigurator extends AbstractResourceConfigurator {
   public static void main(String[] args) {
      generatePlexusComponentsXmlFile(new ComponentsConfigurator());
   }

   @Override
   public List<Component> defineComponents() {
      List<Component> all = new ArrayList<Component>();

      all.add(A(TransactionsPipeline.class));
      all.add(A(TransactionsReportManager.class));
      all.add(A(TransactionsReportDelegate.class));
      all.add(A(TransactionsReportAggregator.class));

      all.add(A(TransactionsHelper.class));
      all.add(A(TransactionsTypeFilter.class));
      all.add(A(TransactionsNameFilter.class));

      all.addAll(new WebComponentConfigurator().defineComponents());

      return all;
   }
}
