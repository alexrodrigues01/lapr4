package eapli.base.daemon.motorFluxoAtividade.protocol;

import eapli.base.daemon.motorFluxoAtividade.MotorFluxoController;
import eapli.framework.csv.util.CsvLineMarshaler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;


public class ProtocolMessageParser {
//    private static final Logger LOGGER = LogManager.getLogger(ProtocolMessageParser.class);
//
//    private static MotorFluxoController controller;
//
//    private ProtocolMessageParser() {
//        // avoid instantiation
//    }
//
//    /**
//     * To inject a different controller for testing purposes.
//     *
//     * @param controller
//     */
//
//    /* package */public static void injectController(final MotorFluxoController controller) {
//        synchronized (lock) {
//            ProtocolMessageParser.controller = controller;
//        }
//    }
//
//    private static final Object lock = new Object();
//
//    private static MotorFluxoController getController() {
//        synchronized (lock) {
//            if (ProtocolMessageParser.controller != null) {
//                return ProtocolMessageParser.controller;
//            }
//        }
//        return new MotorFluxoController();
//    }
//
//    /**
//     * Parse and build the request.
//     *
//     * @param inputLine
//     * @return
//     */
//    public static ProtocolRequest parse(final String inputLine) {
//        // as a fallback make sure we return unknown
//        ProtocolRequest request = new UnknownRequest(inputLine);
//
//        // parse to determine which type of request and if it is sintactally valid
//        String[] tokens;
//        try {
//            tokens = CsvLineMarshaler.tokenize(inputLine).toArray(new String[0]);
//            if ("GET_AVAILABLE_MEALS".equals(tokens[0])) {
//                request = parseGetAvailableMeals(inputLine, tokens);
//            } else if ("BOOK_A_MEAL".equals(tokens[0])) {
//                request = parseBookAMeal(inputLine, tokens);
//            }
//
//            // Minha parte
//            if("GET_NR_TAREFAS_PENDENTES_ASSIGNADAS".equals(tokens[0])){
//                request=parseGetTarefasPendentesAssignadas(inputLine,tokens);
//            }else if("GET_NR_TAREFAS_PENDENTES_TERMINADAS".equals(tokens[0])) {
//                request=parseGetTarefasPendentesTerminadas(inputLine,tokens);
//            }else if("GET_NR_TAREFAS_EM_BREVE".equals(tokens[0])) {
//                request=parseGetTarefasTerminamBreve(inputLine,tokens);
//            }
//
//        } catch (final ParseException e) {
//            LOGGER.info("Unable to parse request: {}", inputLine);
//            request = new ErrorInRequest(inputLine, "Unable to parse request");
//        }
//
//        return request;
//    }
//
//    private static ProtocolRequest parseGetTarefasTerminamBreve(String inputLine, String[] tokens) {
//        ProtocolRequest request;
//        if (tokens.length != 2) {
//            request = new ErrorInRequest(inputLine, "Wrong number of parameters");
//        } else if (!isStringParam(tokens[1])) {
//            request = new ErrorInRequest(inputLine, "Both date and meal type must be inside quotes");
//        } else {
//            request = new GetTarefasAssignadasRequest(getController(), inputLine, CsvLineMarshaler.unquote(tokens[1]),3);
//        }
//        return request;
//    }
//
//    private static ProtocolRequest parseGetTarefasPendentesTerminadas(String inputLine, String[] tokens) {
//        ProtocolRequest request;
//        if (tokens.length != 2) {
//            request = new ErrorInRequest(inputLine, "Wrong number of parameters");
//        } else if (!isStringParam(tokens[1])) {
//            request = new ErrorInRequest(inputLine, "Both date and meal type must be inside quotes");
//        } else {
//            request = new GetTarefasAssignadasRequest(getController(), inputLine, CsvLineMarshaler.unquote(tokens[1]),2);
//        }
//        return request;
//    }
//
//    private static ProtocolRequest parseGetTarefasPendentesAssignadas(String inputLine, String[] tokens) {
//        ProtocolRequest request;
//        if (tokens.length != 2) {
//            request = new ErrorInRequest(inputLine, "Wrong number of parameters");
//        } else if (!isStringParam(tokens[1])) {
//            request = new ErrorInRequest(inputLine, "Both date and meal type must be inside quotes");
//        } else {
//            request = new GetTarefasAssignadasRequest(getController(), inputLine, CsvLineMarshaler.unquote(tokens[1]),1);
//        }
//        return request;
//
//    }
//
//    private static ProtocolRequest parseBookAMeal(final String inputLine, final String[] tokens) {
//        ProtocolRequest request;
//        if (tokens.length != 3) {
//            request = new ErrorInRequest(inputLine, "Wrong number of parameters");
//        } else if (isStringParam(tokens[1])) {
//            request = new ErrorInRequest(inputLine, "meal id must not be inside quotes");
//        } else if (!isStringParam(tokens[2])) {
//            request = new ErrorInRequest(inputLine, "user id must be inside quotes");
//        } else {
//            request = new BookAMealRequest(getController(), inputLine, CsvLineMarshaler.unquote(tokens[1]),
//                    CsvLineMarshaler.unquote(tokens[2]));
//        }
//        return request;
//    }
//
//    private static boolean isStringParam(final String string) {
//        return string.length() >= 2 && string.charAt(0) == '"' && string.charAt(string.length() - 1) == '"';
//    }
//
//    private static ProtocolRequest parseGetAvailableMeals(final String inputLine, final String[] tokens) {
////        ProtocolRequest request;
////        if (tokens.length != 3) {
//////            request = new ErrorInRequest(inputLine, "Wrong number of parameters");
////        } else if (!isStringParam(tokens[1]) || !isStringParam(tokens[2])) {
//////            request = new ErrorInRequest(inputLine, "Both date and meal type must be inside quotes");
////        } else {
////            request = new GetAvailableMealsRequest(getController(), inputLine, CsvLineMarshaler.unquote(tokens[1]),
////                    CsvLineMarshaler.unquote(tokens[2]));
////        }
//        return null;
//    }
//}

}
