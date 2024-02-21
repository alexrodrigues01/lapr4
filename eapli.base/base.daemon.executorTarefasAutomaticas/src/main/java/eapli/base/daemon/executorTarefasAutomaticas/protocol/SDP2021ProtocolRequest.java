package eapli.base.daemon.executorTarefasAutomaticas.protocol;

public abstract class SDP2021ProtocolRequest {

    protected final String request;

    protected boolean goodBye;

    protected SDP2021ProtocolRequest(final String inputRequest, boolean goodBye) {
        this.request = inputRequest;
        this.goodBye = goodBye;
    }

    /**
     * Executes the requested action and builds the response to the client.
     *
     * @return the response to send back to the client
     */
    public abstract String execute();
    
    protected abstract String messageType();

    /**
     * Indicates the object is a goodbye message, that is, a message that will close the
     *      * connection to the client.
     *      *
     * @return {@code true} if the object is a a goodbye message.
     */
    public boolean isGoodbye() {
        return goodBye;
    }

    protected String buildServerError(final String errorDescription) {
        final BaseErrorRequest r = new BaseErrorRequest(request, errorDescription) {

            @Override
            protected String messageType() {
                return "SERVER_ERROR";
            }

        };
        return r.buildResponse();
    }

    protected String buildBadRequest(final String errorDescription) {
        final BaseErrorRequest r = new BaseErrorRequest(request, errorDescription) {

            @Override
            protected String messageType() {
                return "BAD_REQUEST";
            }

        };
        return r.buildResponse();
    }
}
