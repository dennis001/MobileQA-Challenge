#!/bin/bash

# Função para verificar se um comando existe
command_exists() {
    command -v "$1" >/dev/null 2>&1
}

# Função para verificar a instalação e imprimir erro se falhar
check_installation() {
    if command_exists "$1"; then
        echo "$2 instalado com sucesso."
    else
        echo "Erro: $2 não foi instalado com sucesso."
        exit 1
    fi
}

# Instalar Node.js
if command_exists node; then
    echo "Node.js já está instalado."
else
    echo "Instalando Node.js..."
    curl -sL https://deb.nodesource.com/setup_14.x | bash -
    apt-get install -y nodejs
fi
check_installation node "Node.js"

# Instalar npm (Node Package Manager)
if command_exists npm; then
    echo "npm já está instalado."
else
    echo "Instalando npm..."
    apt-get install -y npm
fi
check_installation npm "npm"

# Instalar Appium
if command_exists appium; then
    echo "Appium já está instalado."
else
    echo "Instalando Appium..."
    npm install -g appium
fi
check_installation appium "Appium"

# Instalar Maven no Windows
if command_exists mvn; then
    echo "Maven já está instalado."
else
    echo "Instalando Maven..."
    if [[ "$OSTYPE" == "msys" ]]; then
        echo "Baixando Maven..."
        curl -O https://downloads.apache.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.zip
        echo "Extraindo Maven..."
        unzip apache-maven-3.8.8-bin.zip -d "$HOME/apache-maven-3.8.8"
        if [ $? -ne 0 ]; then
            echo "Erro ao extrair o arquivo zip do Maven."
            exit 1
        fi
        echo "Configurando variáveis de ambiente..."
        export PATH=$PATH:"$HOME/apache-maven-3.8.8/apache-maven-3.8.8/bin"
        echo "Deletando arquivo .zip..."
        rm apache-maven-3.8.8-bin.zip
    else
        echo "Instalando Maven no Linux..."
        apt-get install -y maven
    fi
fi
check_installation mvn "Maven"

# Instalar JDK
if command_exists java; then
    echo "JDK já está instalado."
else
    echo "Instalando JDK..."
    apt-get install -y openjdk-11-jdk
fi
check_installation java "JDK"

# Instalar Android SDK
if command_exists adb; then
    echo "Android SDK já está instalado."
else
    echo "Instalando Android SDK..."
    apt-get install -y android-sdk
fi
check_installation adb "Android SDK"

# Verificar instalações
echo "Verificando instalações..."
node -v
npm -v
appium -v
mvn -v
java --version
adb version

echo "Todas as dependências foram instaladas com sucesso!"