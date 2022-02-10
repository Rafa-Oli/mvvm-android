# MVVM Kotlin
Projeto simples onde foi aplicado arquitetura MVVM, simulando um padrão Observer com o LiveData(androidx.lifecycle)

> O LiveData é um armazenador de dados observável.Como queremos realizar modificações de dados utilizaremos o MutableLiveData. A grande diferança do LiveData para MutableLiveData, é que o MutableLiveData possui métodos públicos- setValue() postValue() - possibilitando modificações de dados. 

##### - Arquitetura MVVM aplicada no projeto:
<p align="center">
    <img src="https://imgur.com/RHBXmJ0.png" width="50%"></img>
</p>

Explicação básica do fluxograma: 
- `ActivityMain` seria nossa `View`, onde ocorre comunicação com o usuário. Seria toda nossa UI  
- Essa `View` tem como controller a `MainActivity`
- A `MainActivity` por sua vez, realiza a ação de escutar, observar modificações de um atributo observável localizada no `ViewModel`
- O `ViewModel` é quem realiza comunicação com o repository, que realiza interação com apis, trazendo dados de backend. Recebendo esses dados, o controller, `MainActivity`, é acionado sobre essa mudança, e por sua vez reproduz o resultado pela View.