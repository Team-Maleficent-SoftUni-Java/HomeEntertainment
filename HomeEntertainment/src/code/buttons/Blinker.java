package code.buttons;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

class Blinker {

    private static final int FIRST_DURATION_SECONDS = 0;
    private static final int FIRST_END_VALUE = 1;
    private static final double SECOND_DURATION_SECONDS = 0.5;
    private static final int SECOND_END_VALUE = 0;
    private static final int THIRD_DURATION_SECONDS = 1;
    private static final int THIRD_END_VALUE = 1;
    private static final int BLINKER_CYCLE_COUNT = 1000;

    static Timeline createBlinker(Node node) {
        Timeline blink = new Timeline(
                new KeyFrame(
                        Duration.seconds(FIRST_DURATION_SECONDS),
                        new KeyValue(
                                node.opacityProperty(),
                                FIRST_END_VALUE,
                                Interpolator.DISCRETE
                        )
                ),
                new KeyFrame(
                        Duration.seconds(SECOND_DURATION_SECONDS),
                        new KeyValue(
                                node.opacityProperty(),
                                SECOND_END_VALUE,
                                Interpolator.DISCRETE
                        )
                ),
                new KeyFrame(
                        Duration.seconds(THIRD_DURATION_SECONDS),
                        new KeyValue(
                                node.opacityProperty(),
                                THIRD_END_VALUE,
                                Interpolator.DISCRETE
                        )
                )
        );
        blink.setCycleCount(BLINKER_CYCLE_COUNT);

        return blink;
    }
}
