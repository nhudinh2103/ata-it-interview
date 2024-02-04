import { LocalizationProvider } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import "@testing-library/jest-dom/vitest";
import { describe, test, expect } from "vitest";
import { render, screen, waitFor } from "@testing-library/react";
import CustomSearch from "../CustomSearch";
import userEvent from "@testing-library/user-event";


const wrapper = ({ children }: { children: React.ReactNode }) => (
    <LocalizationProvider dateAdapter={AdapterDayjs}>{children}</LocalizationProvider>
);

describe("CustomSearch tests", () => {

    test("Orders are fetched", () => {
        render(<CustomSearch />, {wrapper});
        waitFor(() => screen.getByText(/ATA-IT bank/i));
        expect(screen.getByText(/2-XXXXXXX1-1/i)).toBeInTheDocument();
    });

});
