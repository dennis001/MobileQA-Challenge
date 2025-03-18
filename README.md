# Projeto MobileQA-Challenge

## Visão Geral
Este projeto é um framework de automação mobile construído usando Java, Maven e Appium. Ele é projetado para facilitar a automação de testes de aplicativos móveis utilizando o padrão de design Page Object Model (POM).

## Estrutura do Projeto
O projeto segue uma estrutura de diretórios padrão do Maven:

```
MobileQA-Challenge
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── example
│   │               └── pages
│   │                   └── BasePage.java
│   └── test
│       └── java
│           └── com
│               └── example
│                   ├── tests
│                   │   └── BaseTest.java
│                   └── utils
│                       └── DriverManager.java
├── pom.xml
└── README.md
```



## Instruções de Configuração

### Pré-requisitos
- Java Development Kit (JDK) 8 ou superior
- Apache Maven
- Appium Server
- Node.js
- Android Studio (para emuladores Android)

### Configuração do Ambiente

#### Configuração Automatizada

Para configurar o ambiente de forma automatizada, utilize os scripts fornecidos:

- **Windows**: 
   Abra o Git Bash ou qualquer terminal bash que você tenha instalado.
   Navegue até o diretório onde o script install_dependencies.sh está salvo.

   Dê permissão de execução ao script:
   `chmod +x install_dependencies.sh`

   Execute o script: 
    `./install_dependencies.sh`
   
- **Linux/macOS**:
   Abra um terminal.
   Navegue até o diretório onde o script install_dependencies_os.sh está salvo.
   
   Dê permissão de execução ao script:
   `chmod +x install_dependencies_os.sh`

   Execute o script:
    `./install_dependencies_os.sh`

#### Configuração Manual

1. **Instalar Java**: Certifique-se de que o JDK está instalado e que o JAVA_HOME está configurado nas variáveis de ambiente.
2. **Instalar Maven**: Baixe e instale o Maven. Certifique-se de que o comando `mvn` está disponível no seu terminal.
3. **Instalar Appium**: Instale o Appium globalmente usando npm:

   ```
   npm install -g appium
   ```
4. **Configurar o Android Studio**: Instale o Android Studio e configure um emulador ou conecte um dispositivo físico.

### Dispositivo e Versão do Android
- O projeto está configurado para rodar em dispositivos Android.
- Certifique-se de que o dispositivo/emulador está rodando a versão 8.0 (Oreo) ou superior do Android.

## Executando os Testes
1. **Iniciar o Servidor Appium**: Abra um terminal e execute:
   ```
   appium
   ```
2. **Construir o Projeto**: Navegue até o diretório do projeto e execute:
   ```
   mvn clean install
   ```
3. **Executar os Testes**: Execute os testes usando Maven:
   ```
   mvn test
   ```


## Aplicativo em Teste
Este projeto é projetado para testar um aplicativo móvel de exemplo. Certifique-se de que o aplicativo está instalado no dispositivo/emulador antes de executar os testes.

## Notas Adicionais
- A classe `BasePage` fornece métodos comuns para interagir com elementos móveis.
- A classe `BaseTest` inicializa o driver do Appium e gerencia o ciclo de vida dos testes.
- A classe `DriverManager` lida com a instância e configuração do driver do Appium.

Para quaisquer problemas ou contribuições, consulte o rastreador de problemas do projeto ou entre em contato com o mantenedor do projeto.