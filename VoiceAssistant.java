import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;
import marytts.LocalMaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VoiceAssistant {
    private static final String PROJECT_ID = "your-project-id";
    private static final String LANGUAGE_CODE = "en-US";
    private static final String VOICE_NAME = "cmu-slt-hsmm";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, I'm your voice assistant. How can I help you?");

        while (true) {
            System.out.print("Say something: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                String text = recognizeSpeech(input);
                System.out.println("You said: " + text);

                String response = generateResponse(text);
                System.out.println("I say: " + response);

                speak(response);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Goodbye!");
    }

    private static String recognizeSpeech(String audioFilePath) throws IOException {
        try (SpeechClient speechClient = SpeechClient.create()) {
            ByteString audioBytes = ByteString.copyFrom(Files.readAllBytes(Paths.get(audioFilePath)));

            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                    .setLanguageCode(LANGUAGE_CODE)
                    .build();
            RecognitionAudio audio = RecognitionAudio.newBuilder()
                    .setContent(audioBytes)
                    .build();

            RecognizeResponse response = speechClient.recognize(config, audio);
            List<SpeechRecognitionResult> results = response.getResultsList();

            if (!results.isEmpty()) {
                SpeechRecognitionResult result = results.get(0);
                return result.getAlternatives(0).getTranscript();
            } else {
                return "";
            }
        }
    }

    private static String generateResponse(String input) {
        String response = "";

        if (input.contains("hello")) {
            response = "Hello, how are you doing today?";
        } else if (input.contains("how are you")) {
            response = "I'm doing well, thank you for asking.";
        } else if (input.contains("what time is it")) {
            response = "The time is " + java.time.LocalTime.now();
        } else {
            response = "I'm sorry, I didn't understand what you said.";
        }

        return response;
    }

    private static void speak(String text) throws MaryConfigurationException, SynthesisException, LineUnavailableException {
        LocalMaryInterface maryTTS = new LocalMaryInterface();
        maryTTS.setVoice(VOICE_NAME);
        maryTTS.setAudioEffects("Volume(dB)=10.0;");
        AudioPlayer player = new AudioPlayer();
        List<String> lines = new ArrayList<>();
        lines.add(text);
        String output = maryTTS.generateText(lines);
        player.setAudio(maryTTS.generateAudio(output));
        player.start();
    }
}
