const API_URL = 'http://localhost:8080/animais';

async function criarAnimal() {
    const nome = document.getElementById('nome').value.trim();
    const especie = document.getElementById('especie').value.trim();
    const idade = document.getElementById('idade').value;

    if (!nome || !especie || !idade) {
        document.getElementById('output').textContent = "Preencha todos os campos obrigatórios (Nome, Espécie, Idade).";
        return;
    }

    const response = await fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nome, especie, idade: parseInt(idade) })
    });
    const data = await response.json();
    document.getElementById('output').textContent = JSON.stringify(data, null, 2);
}

async function buscarPorId() {
    const id = document.getElementById('idBuscar').value.trim();
    if (!id) {
        document.getElementById('output').textContent = "Informe o ID para buscar.";
        return;
    }

    const response = await fetch(`${API_URL}/${id}`);
    const data = await response.json();
    document.getElementById('output').textContent = JSON.stringify(data, null, 2);
}

async function buscarPorEspecie() {
    const especie = document.getElementById('especieBuscar').value.trim();
    if (!especie) {
        document.getElementById('output').textContent = "Informe a espécie para buscar.";
        return;
    }

    const response = await fetch(`${API_URL}/especie/${especie}`);
    const data = await response.json();
    document.getElementById('output').textContent = JSON.stringify(data, null, 2);
}

async function buscarPorIdade() {
    const idade = document.getElementById('idadeBuscar').value.trim();
    if (!idade) {
        document.getElementById('output').textContent = "Informe a idade para buscar.";
        return;
    }

    const response = await fetch(`${API_URL}/idadeMaiorQue/${idade}`);
    const data = await response.json();
    document.getElementById('output').textContent = JSON.stringify(data, null, 2);
}

async function listarTodos() {
    const response = await fetch(API_URL);
    const data = await response.json();
    document.getElementById('output').textContent = JSON.stringify(data, null, 2);
}

async function deletarAnimal() {
    const id = document.getElementById('idDeletar').value.trim();
    if (!id) {
        document.getElementById('output').textContent = "Informe o ID para deletar.";
        return;
    }

    const response = await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
    if (response.ok) {
        document.getElementById('output').textContent = `Animal com ID ${id} deletado com sucesso.`;
    } else {
        document.getElementById('output').textContent = `Erro ao deletar o animal.`;
    }
}

async function atualizarAnimal() {
    const id = document.getElementById('idAtualizar').value.trim();
    const nome = document.getElementById('nomeAtualizar').value.trim();
    const especie = document.getElementById('especieAtualizar').value.trim();
    const idade = document.getElementById('idadeAtualizar').value;

    if (!id || !nome || !especie || !idade) {
        document.getElementById('output').textContent = "Preencha todos os campos obrigatórios (ID, Nome, Espécie, Idade) para atualizar.";
        return;
    }

    const response = await fetch(`${API_URL}/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nome, especie, idade: parseInt(idade) })
    });

    const data = await response.json();
    document.getElementById('output').textContent = JSON.stringify(data, null, 2);
}

async function buscarPorNome() {
    const nome = document.getElementById('nomeBuscar').value.trim();
    if (!nome) {
        document.getElementById('output').textContent = "Informe o nome para buscar.";
        return;
    }

    const response = await fetch(`${API_URL}/nome/${nome}`);
    const data = await response.json();
    document.getElementById('output').textContent = JSON.stringify(data, null, 2);
}