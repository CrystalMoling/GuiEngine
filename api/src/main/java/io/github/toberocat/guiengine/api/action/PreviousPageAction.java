package io.github.toberocat.guiengine.api.action;

import io.github.toberocat.guiengine.api.components.provided.paged.PagedComponent;
import io.github.toberocat.toberocore.action.Action;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Created: 30.04.2023
 *
 * @author Tobias Madlberger (Tobias)
 */
public class PreviousPageAction extends Action {
    private final @NotNull PagedComponent pagedComponent;

    public PreviousPageAction(@NotNull PagedComponent pagedComponent) {
        this.pagedComponent = pagedComponent;
    }

    @Override
    public @NotNull String label() {
        return pagedComponent.getId() + ":previous";
    }

    @Override
    public void run(@NotNull Player player) {
        int value = (pagedComponent.getShowingPage() - 1)
                % pagedComponent.getAvailablePages();
        if (value < 0)
            return;
        pagedComponent.setShowingPage(value);
    }
}
