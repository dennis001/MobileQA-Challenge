#!/bin/bash

# Função para verificar se um comando existe
command_exists() {
    command -v "$1" >/dev/null 2>&1
}

# Atualizar o sistema
echo "Atualizando o sistema..."
sudo apt-get update

# Instalar Node.js
if command_exists node; then
    echo "Node.js já está instalado."
else
    echo "Instalando Node.js..."
    sudo apt-get install -y nodejs
fi

# Instalar npm (Node Package Manager)
if command_exists npm; then
    echo "npm já está instalado."
else
    echo "Instalando npm..."
    sudo apt-get install -y npm
fi

# Instalar Appium
if command_exists appium; then
    echo "Appium já está instalado."
else
    echo "Instalando Appium..."
    npm install -g appium
fi

# Instalar Maven
if command_exists mvn; then
    echo "Maven já está instalado."
else
    echo "Instalando Maven..."
    sudo apt-get install -y maven
fi

# Instalar JDK
if command_exists java; then
    echo "JDK já está instalado."
else
    echo "Instalando JDK..."
    sudo apt-get install -y openjdk-11-jdk
fi

# Instalar Android SDK
if command_exists adb; then
    echo "Android SDK já está instalado."
else
    echo "Instalando Android SDK..."
    sudo apt-get install -y android-sdk
fi

# Verificar instalações
echo "Verificando instalações..."
node -v
npm -v
appium -v
mvn -v
java --version
adb version
mvn clean install

echo "Todas as dependências foram instaladas com sucesso!"