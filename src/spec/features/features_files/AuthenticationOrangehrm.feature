@LOG
Feature: Authentification utilisateur sur OrangeHRM
  En tant qu utilisateur je souhaite me connecter et me deconnecter sur OrangeHRM.

  Background: 
    Given je suis sur la page de connexion d OrangeHRM "orange.url"
    When je saisis un nom d utilisateur "admin"
    And je saisis un mot de passe  "admin123"
    And je clique sur le bouton de connexion

  @login
  Scenario: Connexion sur OrangeHRM réussies
    Then je me redirige vers le tableau de bord d OrangeHRM

  @logout
  Scenario: Deconnexion sur OrangeHRM réussies
    And je clique sur l icone de proprieteaire du compte
    And je clique sur le bouton de déconnexion
    Then je me redirige vers la page de connexion
