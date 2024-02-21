package eapli.base.daemon.executorTarefasAutomaticas.protocol;

public class ExecutarTarefaRequest extends SDP2021ProtocolRequest {

    public ExecutarTarefaRequest(final String request,
                                       final String userId, final int estadoTarefaPendente, boolean goodBye) {
        super(request, goodBye);
    }

    @Override
    public String execute() {
        return "Tarefa";
    }

    @Override
    protected String messageType() {
        return null;
    }
}
