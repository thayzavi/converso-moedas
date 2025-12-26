# 💱 Conversor de Moedas em Java

Projeto de um **Conversor de Moedas em Java**, desenvolvido com o objetivo de praticar:
- Consumo de APIs externas
- Programação Orientada a Objetos (POO)
- Tratamento de exceções
- Validação de dados
- Organização de código em camadas

O sistema consome dados reais da **ExchangeRate API**, permitindo converter valores entre diferentes moedas de forma simples e interativa via terminal.

---

## 📌 Funcionalidades

- ✅ Escolha da moeda base
- ✅ Escolha da moeda destino
- ✅ Conversão de valores em tempo real
- ✅ Validação de moedas permitidas
- ✅ Validação de valores numéricos
- ✅ Menu interativo (executa várias conversões)
- ✅ Tratamento de erros (API e entrada do usuário)

---

## 🛠️ Tecnologias Utilizadas

- **Java 11+**
- **HttpClient (java.net.http)** – para requisições HTTP
- **Gson** – para conversão de JSON em objetos Java
- **ExchangeRate API** – API de taxas de câmbio
- **Scanner** – para entrada de dados no terminal

---

## 🌐 API Utilizada

**ExchangeRate API**

Exemplo de endpoint consumido:
https://v6.exchangerate-api.com/v6/SUA_API_KEY/latest/USD

A API retorna as taxas de conversão no formato JSON, que são mapeadas automaticamente para objetos Java.

---
