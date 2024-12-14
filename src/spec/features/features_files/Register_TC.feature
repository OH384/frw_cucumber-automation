@tag
Feature: Je rempli le formulaire
  En tant que utilisateur je souhaite remplir le formulaire afin de m enregistrer

  @module_register
  Scenario Outline: Remplir le formulaire register
    Given je me connecte sur l application Mercury
    When je me connecte sur la page enregistrement
    When je saisi un data dans le champs firstname"<firstname>"
    When je saisi un data dans le champs lastname"<lastname>"

    Examples: 
      | firstname | lastname  |
      | Olfa      | Hadhbaoui |
      | Amine     | Ferjani   |
