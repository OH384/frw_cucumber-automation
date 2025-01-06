@TNR
Feature: je rempli le formulaire
  En tant que utilisateur je souhaite remplir le formulaire  afin de m enregistrer
  @module_register
  Scenario Outline: Remplir le formulaire register
    Given je me connecte sur la page enregistrement
    When je clique sur le Bouton Envoyer
    And je saisi le First Name "<First Name>"
    And je saisi le Last Name "<Last Name>"
    And je saisi le Phone Number "<Phone Number>"
    And je saisi le Address Email "<Address Email>"
    And je saisi le Address One "<Address One>"
    And je saisi le City Name "<City Name>"
    And je saisi le State Name "<State Name>"
    And je saisi le Postal Code "<Postal Code>"
    And je selectionne le Country Name "<Country Name>"
    And je saisi le User Name "<User Name>"
    And je saisi le Password "<Password>"
    And je saisi le Confirm Password "<Confirm Password>"
    And je clique sur le Bouton Envoyer
    Then je me redirige vers la page validation du formulaire inscription "<validation>"

    Examples: 
      |username|lastname|Phone Number|Address Email  |Address One|City Name|State Name|Postal Code|Country Name|User Name|Password |Confirm Password|validation                    |
      |zied      |hannachi |  56203203  |zied@gmail.com | ariana    |menzeh   | tunis    |  2040     | TUNISIA    | testz   | test02  |test02          |Note: Your user name is testz.|
      |amine     |ferjani  |  98323639  |amine@gmail.com| manouba   |mornaguia| tunis    |  2010     | TUNISIA    | testa   | test03  |test03          |Note: Your user name is testa.|
      
