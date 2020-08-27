/**
 * Represents a command by the user to delete a task into the list of tasks.
 * A DeleteCommand object has a task number to represent the task to be deleted.
 */
public class DeleteCommand extends Command {
    private int taskNum;

    /**
     * Instantiates a DeleteCommand object.
     * @param taskNum The task number to be deleted.
     */
    public DeleteCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * Executes the command by deleting the specified task from the list, replying the user,
     * and updating the list of tasks stored in the computer.
     * @param tasks List of all the tasks of the user.
     * @param ui Replies the user.
     * @param storage Stores the new task in the computer.
     * @throws DukeException If there are no tasks, or an invalid task number is given.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (Task.totalTasks == 0) {
            throw new DukeException("You don't have any tasks yet!");
        }

        if (this.taskNum == 0 || this.taskNum > Task.totalTasks) {
            throw new DukeException("You don't have a task with that number! ><\n" +
                    "Can you try a different number?");
        }

        Task.totalTasks--;
        Task t = tasks.getTask(this.taskNum);
        tasks.deleteTask(this.taskNum);
        ui.showDelete(t);
        storage.updateData(tasks);
    }

    /**
     * Returns false as the command is not an exit command.
     * @return False.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}