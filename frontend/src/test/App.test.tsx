
import { describe, expect, test } from "vitest";
import App from "../App";
import '@testing-library/jest-dom/vitest'
import { render, screen } from "@testing-library/react";

describe("App test", () => {
    test("component renders", () => {
        render(<App />);
        expect(screen.getByText(/ATA-IT bank/i)).toBeInTheDocument();
    });
});
