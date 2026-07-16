# chess-system (course)

Projeto desenvolvido como parte da **Seção 23: Bônus: Projeto Sistema jogo de xadrez** do curso do **Nélio Alves**.

A ideia do módulo foi sair do básico que nos foi apresentado e montar uma aplicação com orientação a objetos, modelando as regras de xadrez de ponta a ponta. O projeto foi uma boa experiência com OO, principalmente para enxergar responsabilidade de classe, composição e domínio.

## Visão Geral

Este projeto simula uma partida de xadrez no terminal, com leitura de jogadas, validação de origem e destino, capturas, controle de turnos, xeque e xeque-mate.

A solução segue uma arquitetura em camadas de domínio:

- `application`: camada de interação com o usuário e execução do jogo
- `boardgame`: base genérica de tabuleiro, posição, peça e exceções de tabuleiro
- `chess`: regras específicas de xadrez, match e peças concretas

Na prática, a aplicação cobre o ciclo completo da partida: recebe entrada do usuário, valida regras de negócio, atualiza o estado do jogo e mostra o resultado no terminal.

## Conceitos Trabalhados

Este módulo trabalha, de forma aplicada, os seguintes conceitos:

- programação orientada a objetos
- encapsulamento e coesão
- herança e polimorfismo
- composição entre objetos
- modelagem de domínio orientada a regras
- tratamento de exceções personalizadas
- uso de enum para cores/estado
- validação de regras de negócio
- organização do código por responsabilidade

## Modelo de Domínio

O domínio foi montado para representar o fluxo principal de uma partida de xadrez:

- `Board`
- `Position`
- `Piece`
- `ChessMatch`
- `ChessPiece`
- `ChessPosition`
- peças concretas: `King`, `Queen`, `Rook`, `Bishop`, `Knight`, `Pawn`

### Relacionamentos principais

- o tabuleiro contém várias posições
- cada posição pode conter uma peça
- a partida controla turno, estado e peças em jogo
- cada peça concreta implementa sua regra de movimento
- a camada `application` orquestra entrada e saída da partida

## Tecnologias Utilizadas

- Java
- Programação orientada a objetos
- IntelliJ IDEA

## Funcionalidades Disponíveis

### Fluxo da partida

- leitura de posição de origem e destino
- validação de jogadas possíveis
- movimentação de peças
- captura de peças
- controle de turno

### Regras de xadrez

- detecção de xeque
- detecção de xeque-mate
- bloqueio de movimentos inválidos

### Interface em terminal

- exibição do tabuleiro
- destaque de movimentos possíveis
- lista de peças capturadas

## Configuração de Ambiente

O projeto roda localmente em modo console, sem dependência de banco de dados ou deploy em nuvem.

Estrutura principal de código:

- `src/application`
- `src/boardgame`
- `src/chess`

## Como Executar

### Pré-requisitos

- Java 17 ou superior

### Execução local

```bash
cd src
javac application/Program.java
java application.Program
```

## Estrutura do Projeto

```text
src
├── application
│   ├── Program.java
│   └── UI.java
├── boardgame
│   ├── Board.java
│   ├── Piece.java
│   ├── Position.java
│   └── BoardException.java
└── chess
   ├── ChessMatch.java
   ├── ChessPiece.java
   ├── ChessPosition.java
   ├── ChessException.java
   ├── Color.java
   └── pieces
      ├── King.java
      ├── Queen.java
      ├── Rook.java
      ├── Bishop.java
      ├── Knight.java
      └── Pawn.java
```

## Observações

Este projeto foi feito como estudo guiado, baseado nas aulas do professor Nélio Alves.

O que eu achei: foi legal e uma boa experiência com orientação a objetos. Entretanto, senti falta de interfaces, de segregar melhor a lógica, de uma granularidade maior dos métodos e de menos acoplamento entre algumas partes do código. Senti também que ele está mal posicionado na ordem do aprendizado do curso, pois está depois do módulo de SpringBoot (que é um ótimo módulo).
