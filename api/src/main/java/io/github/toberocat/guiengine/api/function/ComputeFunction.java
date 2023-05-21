package io.github.toberocat.guiengine.api.function;

import io.github.toberocat.guiengine.api.GuiEngineApi;
import io.github.toberocat.guiengine.api.context.GuiContext;
import org.jetbrains.annotations.NotNull;

/**
 * Created: 30.04.2023
 *
 * @author Tobias Madlberger (Tobias)
 */
public interface ComputeFunction {
    @NotNull String compute(@NotNull GuiEngineApi api,
                            @NotNull GuiContext context,
                            @NotNull String value);

    boolean checkForFunction(@NotNull String value);
}
