package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.getErrorMessageForDuplicatePrefixes;
import static seedu.address.logic.commands.CommandTestUtil.PLAN_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.PLAN_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PLAN_AMY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PLAN;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.PlanCommand;
import seedu.address.model.person.Plan;

public class PlanCommandParserTest {

    private final PlanCommandParser parser = new PlanCommandParser();

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        assertParseFailure(parser, "1 " + VALID_PLAN_AMY,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, PlanCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_blankPrefixedValue_failure() {
        assertParseFailure(parser, "1 " + PREFIX_PLAN + "   ", Plan.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, "1 " + PREFIX_PLAN + "Bench Press",
                Plan.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_validArgs_returnsPlanCommand() {
        PlanCommand expectedCommand = new PlanCommand(INDEX_FIRST_PERSON, new Plan(VALID_PLAN_AMY));

        assertParseSuccess(parser, "1" + PLAN_DESC_AMY, expectedCommand);
    }

    @Test
    public void parse_repeatedPlanValue_failure() {
        String validExpectedCommandString = "1" + PLAN_DESC_AMY;

        // multiple wp/ values are not allowed
        assertParseFailure(parser, "1" + PLAN_DESC_AMY + PLAN_DESC_BOB,
                getErrorMessageForDuplicatePrefixes(PREFIX_PLAN));

        // invalid value followed by valid value still reports duplicate prefix first
        assertParseFailure(parser, "1 " + PREFIX_PLAN + "Bench Press" + PLAN_DESC_AMY,
                getErrorMessageForDuplicatePrefixes(PREFIX_PLAN));

        // valid value followed by invalid value still reports duplicate prefix first
        assertParseFailure(parser, validExpectedCommandString + " " + PREFIX_PLAN + "Bench Press",
                getErrorMessageForDuplicatePrefixes(PREFIX_PLAN));
    }
}

