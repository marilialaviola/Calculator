Feature: Calcular
  Scenario: Somar Dois Numeros Inteiros Positivos
    Given abro a calculadora do Google no meu smartphone
    When seleciono "5" mais "3" e pressiono o botao Igual
    Then exibe o resultado como "8"

  Scenario: Diminuir Dois Numeros Inteiros Positivos
    Given abro a calculadora do Google no meu smartphone
    When seleciono "9" menos "3" e pressiono o botao Igual
    Then exibe o resultado como "6"

  Scenario: Dividir um Numero Inteiro Positivo
    Given abro a calculadora do Google no meu smartphone
    When seleciono "9" dividido "3" e pressiono o botao Igual
    Then exibe o resultado como "3"

  Scenario: Multiplicar Dois Numeros Inteiros Positivos
    Given abro a calculadora do Google no meu smartphone
    When seleciono "3" vezes "2" e pressiono o botao Igual
    Then exibe o resultado como "6"