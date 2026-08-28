#!/usr/bin/env bash
# Compila e executa o jogo. Uso: ./compilar.sh
set -e
javac -encoding UTF-8 -d out $(find src -name "*.java")
echo "Compilado com sucesso. Iniciando o jogo..."
java -cp out missao.Main
