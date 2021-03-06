package org.unidal.cat.plugin.transactions;

import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;
import org.unidal.cat.core.document.spi.Document;
import org.unidal.cat.core.report.menu.MenuLinkBuilder;
import org.unidal.cat.core.report.menu.MenuManager;
import org.unidal.cat.spi.analysis.pipeline.AbstractPipeline;
import org.unidal.cat.spi.analysis.pipeline.Pipeline;
import org.unidal.lookup.annotation.Named;
import org.unidal.web.mvc.ActionContext;

@Named(type = Pipeline.class, value = TransactionsConstants.NAME, instantiationStrategy = Named.PER_LOOKUP)
public class TransactionsPipeline extends AbstractPipeline implements Initializable {
   @Override
   protected boolean hasAnalyzer() {
      return false;
   }

   @Override
   public void initialize() throws InitializationException {
      lookup(MenuManager.class).register(TransactionsConstants.NAME, "Transactions", "glyphicon glyphicon-time",
            new MenuLinkBuilder() {
               @Override
               public String build(ActionContext<?> ctx) {
                  return ctx.getQuery().uri("/r/ts") //
                        .get("type").get("").get("name").get("").get("group").get("").toString();
               }
            });

      Document.USER.register(TransactionsConstants.NAME, "Transaction Summary");
   }
}
