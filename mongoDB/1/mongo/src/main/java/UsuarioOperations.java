import java.util.List;

public class UsuarioOperations {

    public static void main(String[] args) {

        MongoDBConnection connection = new MongoDBConnection();

        // Exemplo de uso
        if (connection.getDatabase() != null) {
            System.out.println("Banco de dados: " + connection.getDatabase().getName());
        }

        Usuario usuarioAlice = new Usuario("Alice", 25);
        Usuario usuarioBob = new Usuario("Bob", 30);
        Usuario usuarioCharlie = new Usuario("Charlie", 35);

        connection.adicionar(List.of(usuarioAlice, usuarioBob, usuarioCharlie));
        listaUsuarios(connection);

        usuarioBob.setIdade(32);
        connection.alterarUsuario(usuarioBob);
        listaUsuarios(connection);

        connection.deletararUsuario(usuarioCharlie);
        listaUsuarios(connection);

    }

    private static void listaUsuarios(MongoDBConnection connection) {
        List<Usuario> usuarios = connection.listarUsuarios();

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

}
