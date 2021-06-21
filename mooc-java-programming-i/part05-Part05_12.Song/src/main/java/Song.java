
public class Song {

    private String artist;
    private String name;
    private int durationInSeconds;

    public Song(String artist, String name, int durationInSeconds) {
        this.artist = artist;
        this.name = name;
        this.durationInSeconds = durationInSeconds;
    }
    
    public boolean equals(Object compared) {
        // primeiro checamos se as referências são iguais
        if (this == compared) {
            return true;
        }
        
        // depois checamos se o objeto não é uma instância de Song
        if (!(compared instanceof Song)) {
            return false;
        }
        
        // agora nós convertemos o objeto para o tipo Song, já que o compilador ainda não entende que ele é do tipo Song
        Song comparedSong = (Song) compared;
        // e comparamos cada uma das variáveis de objeto
        if (this.artist.equals(comparedSong.artist) &&
            this.name.equals(comparedSong.name) &&
            this.durationInSeconds == comparedSong.durationInSeconds) {
            return true;
        }
        // se tudo falhar, retornamos false
        return false;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.name + " (" + this.durationInSeconds + " s)";
    }


}
