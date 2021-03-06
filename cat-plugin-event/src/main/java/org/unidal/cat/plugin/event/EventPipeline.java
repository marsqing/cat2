package org.unidal.cat.plugin.event;

import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;
import org.unidal.cat.core.document.spi.Document;
import org.unidal.cat.core.report.menu.MenuLinkBuilder;
import org.unidal.cat.core.report.menu.MenuManager;
import org.unidal.cat.spi.analysis.pipeline.AbstractPipeline;
import org.unidal.cat.spi.analysis.pipeline.Pipeline;
import org.unidal.lookup.annotation.Named;
import org.unidal.web.mvc.ActionContext;

@Named(type = Pipeline.class, value = EventConstants.NAME, instantiationStrategy = Named.PER_LOOKUP)
public class EventPipeline extends AbstractPipeline implements Initializable {
   @Override
   public void initialize() throws InitializationException {
      lookup(MenuManager.class).register(EventConstants.NAME, "Event", "fa fa-flag",
            new MenuLinkBuilder() {
               @Override
               public String build(ActionContext<?> ctx) {
                  return ctx.getQuery().uri("/r/e") //
                        .get("type").get("").get("name").get("").get("group").get("").toString();
               }
            });

      Document.USER.register(EventConstants.NAME, "Event");
   }
}
