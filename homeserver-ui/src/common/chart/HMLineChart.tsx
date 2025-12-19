import { CartesianGrid, Line, LineChart, Tooltip, XAxis, YAxis } from "recharts";
import { DeviceSignalData } from "../../features/deviceData/types";
import { CELSIUS_UNIT_SYMBOL } from "../constants";

export type LineChartProps = {
    data: DeviceSignalData[];
};

type LineChartData = {
    name: string;
    value: any;
};

// TODO: Use responsive container
// https://recharts.github.io/en-US/api/ResponsiveContainer/

// Use a numeric/time data-key for X-axis, not categorical
// “name” strings — e.g. dataKey="timestamp" and set XAxis
// to treat it as continuous (number or actual Date → number)
// so spacing corresponds to real time intervals rather than
// uniform categories. That avoids weird uneven spacing.

export const HMLineChart: React.FC<LineChartProps> = ({ data }) => {
    const mappedData: LineChartData[] = data.map(d => {
        return { name: d.measurementTime, value: d.temperatureCelsius };
    });

    return (
        <div style={{ width: "100%" }}>
            <LineChart
                style={{ width: "100%", height: '100%' }}
                responsive
                data={mappedData}
                margin={{
                    top: 10,
                    right: 30,
                    left: 0,
                    bottom: 240,
                }}
            >
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="name" angle={90} label="time" tickMargin={120} />
                <YAxis dataKey="value" label={CELSIUS_UNIT_SYMBOL} tickMargin={12}/>
                <Tooltip />
                <Line
                    connectNulls
                    type="monotone"
                    dataKey="value"
                    stroke="#8884d8"
                    fill="#8884d8"
                />
            </LineChart>
        </div>
    );
};
