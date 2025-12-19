import "@testing-library/jest-dom/vitest";
import { vi } from "vitest";

vi.mock("./common/authentication/keycloakSingleton", () => ({
    getKeycloak: vi.fn(() => ({
        token: "mock-token",
        updateToken: vi.fn().mockResolvedValue(true),
    })),
    initKeycloak: vi.fn().mockResolvedValue({
        token: "mock-token",
        updateToken: vi.fn().mockResolvedValue(true),
    }),
}));
