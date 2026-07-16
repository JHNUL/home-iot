import type { JSX } from "react";
import { useState } from "react";

type DayEntry = {
    day: string;
    content: string;
};

const INITIAL_DAYS: DayEntry[] = [
    { day: "Monday", content: "" },
    { day: "Tuesday", content: "" },
    { day: "Wednesday", content: "" },
    { day: "Thursday", content: "" },
    { day: "Friday", content: "" },
    { day: "Saturday", content: "" },
    { day: "Sunday", content: "" },
];

const PenIcon = (): JSX.Element => {
    return (
        <svg
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            strokeWidth="2"
            strokeLinecap="round"
            strokeLinejoin="round"
            className="h-5 w-5"
        >
            <path d="M12 20h9" />
            <path d="M16.5 3.5a2.12 2.12 0 013 3L7 19l-4 1 1-4 12.5-12.5z" />
        </svg>
    );
};

export const Calendar = (): JSX.Element => {
    const [days, setDays] = useState(INITIAL_DAYS);
    const [editingIndex, setEditingIndex] = useState<number | null>(null);
    const [draftContent, setDraftContent] = useState("");

    const updateContent = (index: number, value: string) => {
        setDays(prev => prev.map((day, i) => (i === index ? { ...day, content: value } : day)));
    };

    const beginEdit = (index: number) => {
        setEditingIndex(index);
        setDraftContent(days[index].content);
    };

    const handleSave = (index: number) => {
        updateContent(index, draftContent);
        setEditingIndex(null);
    };

    const handleCancel = () => {
        setEditingIndex(null);
        setDraftContent("");
    };

    return (
        <div className="w-full max-w-4xl rounded-lg border border-slate-200 bg-white dark:border-slate-700 dark:bg-slate-900">
            {days.map((day, index) => (
                <div
                    key={day.day}
                    className="flex min-h-18 border-b border-slate-200 dark:border-slate-700 last:border-b-0"
                >
                    <div className="w-36 shrink-0 border-r border-slate-200 px-4 py-3 font-medium text-slate-800 dark:border-slate-700 dark:text-slate-200">
                        {day.day}
                    </div>

                    <div className="flex flex-1 items-start gap-3 px-4 py-3">
                        <div className="flex-1">
                            {editingIndex === index ? (
                                <textarea
                                    autoFocus
                                    value={draftContent}
                                    onChange={e => {
                                        setDraftContent(e.target.value);
                                    }}
                                    className="min-h-14 w-full resize-none rounded-md border border-slate-300 bg-white p-2 text-slate-900 outline-none focus:border-slate-500 dark:border-slate-600 dark:bg-slate-800 dark:text-slate-100"
                                />
                            ) : (
                                <div className="whitespace-pre-wrap text-slate-700 dark:text-slate-300">
                                    {day.content || (
                                        <span className="italic text-slate-400 dark:text-slate-500">
                                            No entry
                                        </span>
                                    )}
                                </div>
                            )}
                        </div>

                        <div className="flex w-24 shrink-0 justify-end">
                            {editingIndex === index ? (
                                <div className="flex-col gap-2">
                                    <button
                                        onClick={() => {
                                            handleSave(index);
                                        }}
                                        className="rounded-md bg-slate-800 min-w-20 px-3 py-1 text-sm text-white hover:bg-slate-700 dark:bg-slate-200 dark:text-slate-900 dark:hover:bg-slate-300"
                                    >
                                        Save
                                    </button>

                                    <button
                                        onClick={handleCancel}
                                        className="rounded-md border border-slate-300 min-w-20 px-3 py-1 text-sm hover:bg-slate-100 dark:border-slate-600 dark:hover:bg-slate-800"
                                    >
                                        Cancel
                                    </button>
                                </div>
                            ) : (
                                <button
                                    aria-label={`Edit ${day.day}`}
                                    onClick={() => {
                                        beginEdit(index);
                                    }}
                                    className="rounded-md p-2 text-slate-600 transition hover:bg-slate-100 hover:text-slate-900 dark:text-slate-400 dark:hover:bg-slate-800 dark:hover:text-slate-100"
                                >
                                    <PenIcon />
                                </button>
                            )}
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
};
