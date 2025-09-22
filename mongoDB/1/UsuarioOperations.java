import java.util.List;

import org.bson.Document;

public class UsuarioOperations {

    private static MongoDBConnection connection;
    public static void main(String[] args) {

        connection = new MongoDBConnection();

        Usuario usuarioAlice = new Usuario("Alice", 25);
        Usuario usuarioBob = new Usuario("Bob", 30);
        Usuario usuarioCharlie = new Usuario("Charlie", 35);

        adicionar(List.of(usuarioAlice, usuarioBob, usuarioCharlie));
        listarUsuarios();

        usuarioBob.setIdade(32);
        alterarUsuario(usuarioBob);
        listarUsuarios();

        connection.deletarUsuario(usuarioCharlie);
        listarUsuarios();


        connection.closeConnection();
    } 

    public void adicionar(List<Usuario> usuarios) {
        List<Document> documents = usuarios.stream().map(u -> u.toDocument()).toList();
        
        try {
            connection.getDatabase().getCollection("usuarios").insertMany(documents);
        } catch (Exception e) {
            System.err.println("Erro ao inserir registros no MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            connection.getDatabase().getCollection("usuarios").find().forEach(d -> usuarios.add(Usuario.fromDocument(d)));
        } catch (Exception e) {
            System.err.println("Erro ao buscar os registros no MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        };
    }

    public void alterarUsuario(Usuario usuario) {
        try {
            connection.getDatabase().getCollection("usuarios").updateOne(new Document().append("nome", usuario.getNome()), usuario.toDocument());
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o registro no MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deletarUsuario(Usuario usuario) {
        try {
            connection.getDatabase().getCollection("usuarios").deleteOne(new Document().append("nome", usuario.getNome()));
        } catch (Exception e) {
            System.err.println("Erro ao atualziar o registro no MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
