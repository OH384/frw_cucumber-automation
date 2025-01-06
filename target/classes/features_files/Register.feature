@TNR
Feature: je verifie la validation du formulaire inscription
  En tant que utilisateur je veux remplir un formulaire  inscription afin de créer un compte

  @register
  Scenario: je verifie la validation du formulaire  inscription
    Given je me connecte sur la page enregistrement
    When je saisi le First Name "olfa"
    And je saisi le Last Name "hadhbaoui"
    And je saisi le Phone Number "97693289"
    And je saisi le Address Email "olfa@gmail.com"
    And je saisi le Address One "tunis"
    And je saisi le City Name "tunis"
    And je saisi le State Name "tunis"
    And je saisi le Postal Code "2011"
    And je selectionne le Country Name "TUNISIA"
    And je saisi le User Name "test"
    And je saisi le Password "test01"
    And je saisi le Confirm Password "test01"
    And je clique sur le Bouton Envoyer
    Then je me redirige vers la page validation du formulaire inscription "Note: Your user name is test."