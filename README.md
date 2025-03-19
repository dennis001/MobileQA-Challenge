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

### Instalar no Emulado
1. **Certifique-se de que o emulador está em execução**:
   ```
   adb devices
   ```
2. **Instale o APK no emulador**:
   ```
   adb install path/to/your/app.apk
   ```
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

## Pipeline no GitHub Actions
   O projeto inclui uma pipeline configurada no GitHub Actions para executar os testes automaticamente.

### Localização do Arquivo
   O arquivo de configuração da pipeline está localizado em:
   ```
   .github/workflows/ci.yml`
   ```

## Aplicativo em Teste

Este projeto utiliza o aplicativo **"opencart-mobile-app-webkul.apk"** para realizar os testes automatizados. Certifique-se de seguir as etapas abaixo para instalar e configurar o aplicativo no dispositivo ou emulador antes de executar os testes.

### Passos para Instalar e Configurar o Aplicativo

1. **Baixe o APK**:
   - Certifique-se de que o arquivo `opencart-mobile-app-webkul.apk` está disponível no seu computador.

2. **Instale o APK no Emulador ou Dispositivo Físico**:
   - **No Emulador**:
     1. Certifique-se de que o emulador está em execução:
        ```bash
        adb devices
        ```
     2. Instale o APK no emulador:
        ```bash
        adb install path/to/opencart-mobile-app-webkul.apk
        ```
   - **No Dispositivo Físico**:
     1. Conecte o dispositivo ao computador e verifique se ele está listado:
        ```bash
        adb devices
        ```
     2. Instale o APK no dispositivo:
        ```bash
        adb install path/to/opencart-mobile-app-webkul.apk
        ```

3. **Abra o Aplicativo**:
   - Após a instalação, abra o aplicativo no dispositivo ou emulador.

4. **Pesquise por "opencart"**:
   - Na tela inicial do aplicativo, pesquise pelo termo **"opencart"**.

5. **Siga as Instruções para Configuração**:
   - Após encontrar o resultado da pesquisa, siga as instruções exibidas no aplicativo para concluir a configuração.

6. **Pronto para Automação**:
   - Após a configuração, o aplicativo estará pronto para ser utilizado nos testes automatizados.


## Notas Adicionais
- A classe `BasePage` fornece métodos comuns para interagir com elementos móveis.
- A classe `BaseTest` inicializa o driver do Appium e gerencia o ciclo de vida dos testes.
- A classe `DriverManager` lida com a instância e configuração do driver do Appium.

Para quaisquer problemas ou contribuições, consulte o rastreador de problemas do projeto ou entre em contato com o mantenedor do projeto.