import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {


    // Variáveis de configuração
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String CLUSTER_URL = "cluster0.prb6exi.mongodb.net"; // Substitua pelo seu cluster se for diferente
    private static final String DATABASE_NAME = "Cluster0"; // Substitua pelo nome do seu banco de dados


    private MongoClient mongoClient;
    private MongoDatabase database;


    public MongoDBConnection() {
        try {
            // String de conexão com credenciais
            String connectionString = String.format("mongodb+srv://"+USERNAME+":"+PASSWORD+"@"+CLUSTER_URL+"/?retryWrites=true&w=majority&appName="+DATABASE_NAME);


            // Configuração do cliente MongoDB
            ConnectionString connString = new ConnectionString(connectionString);
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connString)
                    .build();


            // Criando o cliente
            mongoClient = MongoClients.create(settings);


            // Selecionando o banco de dados
            database = mongoClient.getDatabase(DATABASE_NAME);

            //Selecionando a collection
            database.listCollectionNames().forEach(c -> System.out.println(c));
            //database.createCollection("usuarios");


            System.out.println("Conexão estabelecida com sucesso ao MongoDB!");
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void adicionar(List<Usuario> usuarios) {
        List<Document> documents = usuarios.stream().map(u -> u.toDocument()).toList();
        
        try {
            database.getCollection("usuarios").insertMany(documents);
        } catch (Exception e) {
            System.err.println("Erro ao inserir registros no MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            database.getCollection("usuarios").find().forEach(d -> usuarios.add(Usuario.fromDocument(d)));
        } catch (Exception e) {
            System.err.println("Erro ao buscar os registros no MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
        return usuarios;
    }

    public void alterarUsuario(Usuario usuario) {
        try {
            database.getCollection("usuarios").updateOne(new Document().append("nome", usuario.getNome()), usuario.toDocument());
        } catch (Exception e) {
            System.err.println("Erro ao atualziar o registro no MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deletararUsuario(Usuario usuario) {
        try {
            database.getCollection("usuarios").deleteOne(new Document().append("nome", usuario.getNome()));
        } catch (Exception e) {
            System.err.println("Erro ao atualziar o registro no MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }


    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexão encerrada com sucesso.");
        }
    }




}