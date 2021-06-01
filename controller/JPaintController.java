package controller;

import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.EventName;
import view.interfaces.IEventCallback;
import view.interfaces.IUiModule;
import view.interfaces.PaintCanvasBase;

import javax.swing.*;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final PaintCanvasBase paintCanvas;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, PaintCanvasBase paintCanvas) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> new Undo(paintCanvas).execute());
        uiModule.addEvent(EventName.REDO, () -> new Redo(paintCanvas).execute());
        uiModule.addEvent(EventName.COPY, () -> new Copy().copy());
        uiModule.addEvent(EventName.PASTE, () -> new Paste().paste());
        uiModule.addEvent(EventName.DELETE, () -> new Delete().delete(paintCanvas));
        uiModule.addEvent(EventName.GROUP, () -> new Group().group(paintCanvas, (ApplicationState) applicationState));
        uiModule.addEvent(EventName.UNGROUP, () -> new Ungroup().ungroup(paintCanvas, (ApplicationState) applicationState));
    }
}
