/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.HiddenSidesPane;

/**
 *
 * @author Agarimo
 */
class SideNode extends Label {

    public SideNode(final String text, final Side side,final HiddenSidesPane pane) {

        super(text + " (Click to pin / unpin)");

        setAlignment(Pos.CENTER);
        setPrefSize(200, 200);

        setOnMouseClicked((MouseEvent event) -> {
            if (pane.getPinnedSide() != null) {
                setText(text + " (unpinned)");
                pane.setPinnedSide(null);
            } else {
                setText(text + " (pinned)");
                pane.setPinnedSide(side);
            }
        });
    }
}
