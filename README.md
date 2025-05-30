# DOCUMENTAÇÃO GLOBAL SOLUTION - JAVA

Este projeto é referente nossa solução.


## Proposta do projeto: 

  O ClimaConecta é uma plataforma colaborativa que permite que comunidades registrem, compartilhem e monitorem condições climáticas em tempo real, promovendo conscientização e resposta rápida a eventos extremos (como enchentes, secas, tempestades etc.).

Nas comunidades, a falta de informação rápida e confiável sobre enchentes e temporais é um problema grave que coloca vidas e propriedades em risco. Muitas vezes, os alertas oficiais não chegam a tempo ou são muito genéricos, sem detalhes sobre riscos específicos em cada rua ou viela. Quem está fora de casa, trabalhando ou estudando, muitas vezes só descobre que a enchente chegou quando já é tarde demais.

É aí que entra o ClimaConecta, uma plataforma feita pela comunidade e para a comunidade, onde os próprios moradores podem registrar e compartilhar informações em tempo real sobre alagamentos, tempestades e outros riscos climáticos. A ideia é simples: se o rio começa a subir, um morador abre o app, tira uma foto, marca a localização e posta um alerta. Esse aviso é imediatamente visto por todos que usam o ClimaConecta na região, permitindo que as pessoas se preparem ou tomem as providências necessárias.



O sistema permite:
- Cadastrar Admin, Clientes
- Publicar Post
- Consultar Clima de Cidades
- Consultar todas as entidades
- Editar todas as entidades
- Integração com banco de dados Oracle (SQL Developer)
- Testes de endpoints via Postman
- Testes de endpoints via Swagger

## Nome Integrantes
<div align="center">

| Nome | RM |
| ------------- |:-------------:|
| Arthur Eduardo Luna Pulini|554848|
|Lucas Almeida Fernandes de Moraes| 557569     |
|Victor Nascimento Cosme|558856|

</div>

## Informações
**1-** 
No arquivo: *application.properties*, peço que adicione no campos: 
- *spring.datasource.username=*
- *spring.datasource.password=*
  
Credenciais do banco Oracle para persistência em banco se não ocorrerá um erro. 

**2-**
Peço que verifique as informações pois as que eu coloquei a baixo são exemplos e podem não funcionar com os mesmos valores.


## 🚀 Começando

⚙️ Executando os testes via *POSTMAN*

Os testes foram realizados via postman a seguir vou falar dos testes realizados em todas as entidades, seguindo o *CRUD* *(Create, Read, Update e Delete)*.
Aconselho seguir a ordem de criação abaixo pois se fizer em ordem aleatória poderá gerar erro.

# Admin:

## Create

Para criar ele tem que está no método *POST* e o comando para criar foi: 

```bash
  http://localhost:8080/admin
```

E um corpo para persistência de exemplo: 

```bash
{
    "nomeUser": "Lucas Almeida", 
    "dataAniversario": "2002-06-11",
    "cpfUser": "021.421.260-22",
    "cep": "02241140"
}
```

## Read

Lembrando que o método é o *GET*.

```bash
  http://localhost:8080/admin
```

E um retorno: 

```bash
[
  {
    "id": 3,
    "nomeUser": "Ismael",
    "dataAniversario": "1111-11-11T03:00:00.000+00:00",
    "cpfUser": "620.751.240-51",
    "endereco": {
      "cep": "02241-140",
      "logradouro": "Rua Carmina Pasqui",
      "bairro": "Vila Dom Pedro II",
      "localidade": "São Paulo",
      "uf": "SP"
    }
  }
]
```

E tem o buscando por id:

```bash
  http://localhost:8080/admin/{id}
```

E um retorno:

```bash
{
  "id": 23,
  "nomeUser": "Lucas Almeida",
  "dataAniversario": "2002-06-11T03:00:00.000+00:00",
  "cpfUser": "021.421.260-22",
  "endereco": {
    "cep": "02241-140",
    "logradouro": "Rua Carmina Pasqui",
    "bairro": "Vila Dom Pedro II",
    "localidade": "São Paulo",
    "uf": "SP"
  }
}
```

## Update

Para fazer a atualização ele tem que está no método *PUT*, nele tem que passar pela URL o *ID* que serve para localizar o admin 
que vai ser modificado e um corpo que vai ser o novo admin, exemplo de chamada: 

1-
```bash
  http://localhost:8080/admin/{id}
```

No corpo: 
```bash
{
    "nomeUser": "User Atualizado", 
    "dataAniversario": "2025-05-27",
    "cpfUser": "021.421.260-22",
    "cep": "02241140"
}
```

## Delete

Para fazer o *Delete* o método que ele tem que estar é o *DELETE*,  nele tem que passar pela URL um *ID* que serve para localizar o admin que vai ser deletado, exemplo: 

```bash
  http://localhost:8080/admin/{id}
```

E nele não vai ter resposta, só se ele não achar o admin com esse *ID*.

---

# Cliente:

## Create

Para criar ele tem que está no método *POST* e o comando para criar foi: 

```bash
  http://localhost:8080/cliente
```

E um corpo para persistência de exemplo: 

```bash
{
    "nomeUser": "Ismael", 
    "dataAniversario": "1111-11-11",
    "cpfUser": "620.751.240-51",
    "cep": "02241140"
}
```

## Read

Lembrando que o método é o *GET*.

```bash
  http://localhost:8080/cliente
```

E um retorno: 

```bash
[
    {
        "id": 3,
        "nomeUser": "Ismael",
        "dataAniversario": "1111-11-11T03:00:00.000+00:00",
        "cpfUser": "620.751.240-51",
        "endereco": {
            "cep": "02241-140",
            "logradouro": "Rua Carmina Pasqui",
            "bairro": "Vila Dom Pedro II",
            "localidade": "São Paulo",
            "uf": "SP"
        }
    }
]
```

E tem o buscando por id:

```bash
  http://localhost:8080/cliente/{id}
```

E um retorno:

```bash
{
    "id": 3,
    "nomeUser": "Ismael",
    "dataAniversario": "1111-11-11T03:00:00.000+00:00",
    "cpfUser": "620.751.240-51",
    "endereco": {
        "cep": "02241-140",
        "logradouro": "Rua Carmina Pasqui",
        "bairro": "Vila Dom Pedro II",
        "localidade": "São Paulo",
        "uf": "SP"
    }
}
```

## Update

Para fazer a atualização ele tem que está no método *PUT*, nele tem que passar pela URL o *ID* que serve para localizar o cliente 
que vai ser modificado e um corpo que vai ser o novo cliente, exemplo de chamada: 

1-
```bash
  http://localhost:8080/cliente/{id}
```

No corpo: 
```bash
{
    "nomeUser": "CLIENTE ATUALIZADO", 
    "dataAniversario": "2025-99-99",
    "cpfUser": "620.751.240-51",
    "cep": "02241140"
}
```

## Delete

Para fazer o *Delete* o método que ele tem que estar é o *DELETE*,  nele tem que passar pela URL um *ID* que serve para localizar o admin que vai ser deletado, exemplo: 

```bash
  http://localhost:8080/cliente/{id}
```

E nele não vai ter resposta, só se ele não achar o cliente com esse *ID*.

---

# Posts:

## Create

Para criar ele tem que está no método *POST* mas no post muda um pouco pois você pode selecionar uma imagem para subir, no postman você tem que ir em *form-data* e ir colocando chave e valor, no tipo texto deixar em *Text* e na imagem mudar para *File*, segue imagem para melhor vizualização: 

```bash
  http://localhost:8080/posts
```

Imagem: 
 ![WhatsApp Image 2025-05-29 at 08 41 37](https://github.com/user-attachments/assets/25f4a132-f7df-469a-8536-6f8d62b103cb)


## Read

Lembrando que o método é o *GET*.

```bash
  http://localhost:8080/posts
```

E um retorno: 

```bash
{
        "id": 3,
        "titulo": "Imagem1",
        "imagemBytes": "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",
        "dataHoraAtual": "2025-05-27T20:06:54.643692",
        "usuario": {
            "id": 5,
            "nomeUser": "Arthur",
            "dataAniversario": "1111-11-11T03:00:00.000+00:00",
            "cpfUser": "341.173.418-39",
            "endereco": {
                "cep": "09080-301",
                "logradouro": "Rua das Figueiras",
                "bairro": "Campestre",
                "localidade": "Santo André",
                "uf": "SP"
            }
        }
    },
```

E tem o buscando por id:

```bash
  http://localhost:8080/posts/{id}
```

E um retorno:

```bash
{
    "id": 2,
    "titulo": "Imagem2",
    "imagemBytes": "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",
    "dataHoraAtual": "2025-05-27T19:55:22.873394",
    "usuario": {
        "id": 4,
        "nomeUser": "Victor",
        "dataAniversario": "1111-11-11T03:00:00.000+00:00",
        "cpfUser": "434.762.508-14",
        "endereco": {
            "cep": "07936-170",
            "logradouro": "Rua Adriano VI",
            "bairro": "Jardim Nossa Senhora Aparecida",
            "localidade": "Francisco Morato",
            "uf": "SP"
        }
    }
}
```

E buscando somente a imagem: 

```bash
  http://localhost:8080/posts/{id}/imagem
```

E o retorno da imagem: 

![image](https://github.com/user-attachments/assets/f2efe619-cbef-461b-be5d-67c26aa414cb)



## Update

Para fazer a atualização ele tem que está no método *PUT*, nele tem que passar pela URL o *ID* que serve para localizar o post 
que vai ser modificado e um corpo que vai ser o novo post, exemplo de chamada: 

1-
```bash
  http://localhost:8080/post/{id}
```

No corpo: 

![image](https://github.com/user-attachments/assets/2cb1ffb8-6879-4fed-85f2-66e16fd9d190)


## Delete

Para fazer o *Delete* o método que ele tem que estar é o *DELETE*,  nele tem que passar pela URL um *ID* que serve para localizar o post que vai ser deletado, exemplo: 

```bash
  http://localhost:8080/post/{id}
```

E nele não vai ter resposta, só se ele não achar o cliente com esse *ID*.

---


# Tempo:

Esse é um endpoint que esta ligado a uma api externa da OpenWeatherMap, que retorna para nós o clima de uma determinada cidada, exemplo: 

## Get

```bash
  http://localhost:8080/tempo/{nome de uma cidade}
```

Retorno: 


```bash
 {
    "main": {
        "temp": 13.35
    },
    "weather": [
        {
            "description": "névoa"
        }
    ],
    "name": "São Paulo"
}
```

---

# Links:

- Link dos deploys: https://ch1-2sem-java.onrender.com
- Vídeo demonstração da solução completa: https://youtu.be/fQEmXm-ahto
- Vídeo pitch:  
