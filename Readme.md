# Conversor de Moedas (Java)

Projeto simples e didático em Java para conversão de moedas usando **API de cotações em tempo real**. Feito para aprendizado — código claro, dividido em 3 classes, usando `HttpClient`, `HttpRequest` e `HttpResponse` (Java 11+).

## Resumo rápido

Este projeto permite escolher entre conversões prontas (menu fixo) — BRL ⇄ USD, BRL ⇄ EUR, ARS ⇄ USD, COP ⇄ USD — e obter o resultado em tempo real pela ExchangeRate API. Saída no terminal com o formato fixo:

```
Valor convertido: 100 BRL = 18.45 USD
```

## Funcionalidades

* Menu interativo no terminal (opções fixas 1–9).
* Requisição HTTP moderna com `HttpClient` / `HttpRequest` / `HttpResponse`.
* Parse JSON com **Gson**.
* Exibe taxa atual e resultado formatado (`Valor convertido: ...`).
* Implementado de forma simples e didática — código fácil de entender e modificar.

## Tecnologias e requisitos

* Java 11 ou superior (necessário para `java.net.http.HttpClient`).
* Biblioteca Gson (ex.: `gson-2.11.0.jar`).
* Chave de API da ExchangeRate (`v6.exchangerate-api.com`).
  Você deve obter a chave (gratuita) no site da ExchangeRate API e inserir no `ConversorService`.

## Estrutura do projeto

```
ConversorMoedas/
│
├── Principal.java               # menu e interação com o usuário
├── Conversor.java   # faz a requisição e calcula a conversão (usa HttpClient)
└── Conversao.java  # modelo para mapear JSON retornado pela API
```

## Configurar a chave da API

No arquivo `Conversor.java`, substitua a constante da chave pela sua:

```java
private static final String API_KEY = "SUA_CHAVE_AQUI";
```

A URL usada tem o formato:

```
https://v6.exchangerate-api.com/v6/SUA_CHAVE_AQUI/latest/BRL
```

## Instalação e execução (Linux / macOS / terminal)

> ⚠️ Executa **linha por linha** no terminal. Não copie tudo de uma vez sem entender — execute cada comando separadamente.

1. Coloque os arquivos `.java` na mesma pasta.
2. Baixe o `gson-2.11.0.jar` e coloque na mesma pasta do projeto (ou informe o caminho correto).
3. Compile:

```bash
javac -cp gson-2.11.0.jar *.java
```

4. Execute:

```bash
java -cp .:gson-2.11.0.jar Main
```

> No Windows, substitua `:` por `;` no classpath:

```bash
java -cp .;gson-2.11.0.jar Main
```

## Observações importantes

* Requer Java 11+ por causa do `HttpClient`.
* Sem a chave API correta a chamada à API não retornará cotações válidas.
* O projeto foi feito com foco em aprendizado — o tratamento de erros é simples e direto.
* Se quiser rodar offline (sem API), é possível adaptar `Conversor` para usar taxas fixas ou um arquivo local.

## Explicação breve das classes

* **Principal.java**: mostra o menu exatamente no formato combinado, lê opção e valor, chama `conversor.converter(origem, destino, valor)` e imprime:
  `Valor convertido: <valor> <origem> = <resultado> <destino>`.
* **Conversor.java**: cria `HttpClient`, monta `HttpRequest` para a URL da ExchangeRate (com sua chave), chama `client.send(...)`, converte o JSON com Gson, lê `conversion_rates` e calcula `valor * taxa`.
* **Conversao.java**: modelo Java simples para receber `base_code` e `conversion_rates` da API.

## Exemplo de execução

1. Inicia o programa.
2. Escolhe opção `1` (BRL -> USD).
3. Digita `100`.
4. Saída esperada:

```
Taxa atual: 1 BRL = 0.1845 USD
Valor convertido: 100.00 BRL = 18.45 USD
```

## Boas práticas e sugestões de melhoria (próximos passos)

* Validar códigos de moeda de forma mais robusta antes de chamar a API.
* Tratar exceções com mensagens mais úteis e retry em caso de falha temporária.
* Adicionar logs simples (ou nível de debug) para entender falhas de rede.
* Migrar para Maven/Gradle para gerenciar dependências (Gson) automaticamente.
* Adicionar testes unitários para a lógica de cálculo (mock da resposta da API).
* Implementar um modo “fallback” com taxas armazenadas localmente para quando a API estiver indisponível.

## Créditos

* Projeto e implementação: você (estudante).
* Curso de suporte e aprendizado: Oracle Next Education (ONE) — Alura. (Inclua essa formação no README conforme a sua preferência.)
* API de cotações: ExchangeRate API ([https://www.exchangerate-api.com](https://www.exchangerate-api.com)).
* Biblioteca JSON: Gson (Google).

## Licença

Use como quiser para estudo. Se for publicar, coloque a licença que preferir (MIT é simples e tradicional).

---


