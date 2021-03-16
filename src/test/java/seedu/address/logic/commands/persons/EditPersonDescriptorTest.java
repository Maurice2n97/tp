package seedu.address.logic.commands.persons;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.persons.PersonCommandTestUtil.DESC_AMY;
import static seedu.address.logic.commands.persons.PersonCommandTestUtil.DESC_BOB;
import static seedu.address.logic.commands.persons.PersonCommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.persons.PersonCommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.persons.PersonCommandTestUtil.VALID_GROUP_HUSBAND;
import static seedu.address.logic.commands.persons.PersonCommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.persons.PersonCommandTestUtil.VALID_PHONE_BOB;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.persons.EditPersonCommand.EditPersonDescriptor;
import seedu.address.testutil.EditPersonDescriptorBuilder;

public class EditPersonDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditPersonDescriptor descriptorWithSameValues = new EditPersonDescriptor(DESC_AMY);
        assertTrue(DESC_AMY.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_AMY.equals(DESC_AMY));

        // null -> returns false
        assertFalse(DESC_AMY.equals(null));

        // different types -> returns false
        assertFalse(DESC_AMY.equals(5));

        // different values -> returns false
        assertFalse(DESC_AMY.equals(DESC_BOB));

        // different name -> returns false
        EditPersonDescriptor editedAmy = new EditPersonDescriptorBuilder(DESC_AMY).withName(VALID_NAME_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different phone -> returns false
        editedAmy = new EditPersonDescriptorBuilder(DESC_AMY).withPhone(VALID_PHONE_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different email -> returns false
        editedAmy = new EditPersonDescriptorBuilder(DESC_AMY).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different address -> returns false
        editedAmy = new EditPersonDescriptorBuilder(DESC_AMY).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different groups -> returns false
        editedAmy = new EditPersonDescriptorBuilder(DESC_AMY).withGroups(VALID_GROUP_HUSBAND).build();
        assertFalse(DESC_AMY.equals(editedAmy));
    }
}
