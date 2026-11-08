package ht.fds.mbds.salhi.llm;

/**
 * Résultat d'une interaction avec le LLM : la réponse à afficher, et les JSON
 * de la requête et de la réponse (pour le mode "debug").
 *
 * @param questionJson    JSON envoyé dans la requête à l'API du LLM
 * @param reponseJson     JSON retourné dans la réponse de l'API du LLM
 * @param reponseExtraite texte de la réponse à afficher à l'utilisateur
 */
public record LlmInteraction(String questionJson, String reponseJson, String reponseExtraite) {
}