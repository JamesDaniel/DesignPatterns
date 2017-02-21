package com.james.music;

/**
 * @author James McGarr
 * REFERENCE https://www.tutorialspoint.com/design_pattern/front_controller_pattern.htm
 */
public class FrontController {
    private Dispatcher dispatcher;
    public FrontController(PlayStopButton playStopButton, SongPlayer songPlayer) {
        this.setDispatcher(new Dispatcher(playStopButton, songPlayer));
    }
    private void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }
    private void trackRequest(USER_EVENT request) {
        System.out.println("Request made " + request);
    }
    public void dispatchRequest(USER_EVENT request) {
        trackRequest(request);

        dispatcher.dispatch(request);
    }
}
