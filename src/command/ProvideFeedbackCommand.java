/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

/**
 *
 * @author sjeew
 */
public class ProvideFeedbackCommand implements Command{
     private Feedback feedback;

    public ProvideFeedbackCommand(Feedback feedback) {
        this.feedback = feedback;
    }

    @Override
    public void execute() {
        feedback.submitFeedback();
    }
}
