@CERTIFICATE
Feature: CheckCertificate

    Scenario Outline:
      When I send certificate "<certificateNumber>"
      Then Certificate verification - "<RESULT>"
      Examples:
        | certificateNumber | RESULT |
        | 45126             | false  |
        | 45924126          | true   |
        | 123456            | true   |
        | 55555543          | false  |
        | 78008248          | true   |
        | 78008248          | false  |
