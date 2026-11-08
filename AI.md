# Utilisation de l'IA — TP 1 (Accès direct à l'API d'un LLM avec Jakarta EE / JSF)

**Outil utilisé :** Claude (Anthropic), via l'interface de chat.

## Erreur pour laquelle l'IA a été utilisée

**Symptôme :** après le déploiement, chaque question envoyée à Gemini retournait l'erreur
`400 : Bad Request ... API key not valid. Please pass a valid API key.`
La clé était pourtant valide (le test `curl` de l'énoncé fonctionnait) et la variable
d'environnement `GEMINI_KEY` était visible dans le terminal d'IntelliJ.

**Diagnostic :** une ligne de diagnostic temporaire a montré que la clé lue par l'application
valait `null` (`DIAG cle null=true`). En relisant le fichier `LlmClientPourGemini.java`, Claude a
identifié la cause à la **ligne 31** :

```java
this.key = System.getenv("GEMINI_API_KEY");   // faux : la variable s'appelle GEMINI_KEY
```

Le code lisait une variable `GEMINI_API_KEY` qui n'existe pas, donc `System.getenv` retournait
`null` et l'URL envoyée à Gemini se terminait par `?key=null`.

**Correction :**

```java
this.key = System.getenv("GEMINI_KEY");
```

Après cette correction, l'application a répondu correctement (conversation de 2 questions en
mode debug).

## Ce que j'ai fait moi-même

- Création du projet, du dépôt GitHub et des commits.
- Test de l'application, avec la conversation de 2 questions en mode debug.
- Provocation des 2 erreurs demandées (fausse clé, rôle `system` à la place de `user`) et retour
  à l'ancien code avec Git.
- Tests du nouveau rôle système.
