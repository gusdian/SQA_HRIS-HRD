Feature: Template P.A
  Scenario: Testing Template P.A
    When HRD klik Menu Performance Appraisal New
    Then HRD klik Create Template
   #Scenario: Data P.A Template
    When HRD tidak menginput Template Name
    Then Template Name Wajib Diisi
    And HRD menginput Template Name
   #Scenario: Data P.A Privilege
   	When HRD memilih Department
   	And HRD memilih Unit
   	Then HRD Complete Process
