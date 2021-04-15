Feature: Calcular
  Scenario: Somar Dois Numeros Inteiros Positivos
    Given abro a calculadora do Google no meu smartphone
    When seleciono "2" mais "3" e pressiono o botao Igual
    Then exibe o resultado como "5"
